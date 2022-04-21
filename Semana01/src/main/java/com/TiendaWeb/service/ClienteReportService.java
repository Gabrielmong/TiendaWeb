/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TiendaWeb.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;


import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author gabri
 */
@Service
public class ClienteReportService {

    private String reportPath;

    public String generateReport(){
        try {
            File file = ResourceUtils.getFile("classpath:ReporteCliente.jasper");
            reportPath = file.getParent();
            // Carga el reporte
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
            // Añade paramáteros (pero para este caso no hay)
            Map<String, Object> parameters = new HashMap<>();
            //Instanciar la conexión
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/techshop", "usuario_prueba", "Usuario_Clave");
            // Llena el reporte
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            // Exporta a PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\ReporteClientes.pdf");
            return reportPath + "\\ReporteClientes.pdf";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
