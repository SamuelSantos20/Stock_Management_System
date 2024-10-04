package util;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import domain.Moviment;
import domain.Product;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RelatorioUtil {

	private final DataUtil dataUtil;
	public void gerarRelatoriocontato(HttpServletResponse response, List<Moviment> lista) {

		try {
			
			System.out.println(lista);
			
			// Configura o tipo de conteúdo e os headers da resposta
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=relatorio.pdf");

			// Criando o escritor de PDF e o documento
			
			//ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter writer = new PdfWriter(response.getOutputStream());
			PdfDocument pdfDoc = new PdfDocument(writer);
			Document document = new Document(pdfDoc);

			// Adicionando o título
			document.add(new Paragraph("Relatório Movimentação").setBold().setFontSize(16));
			document.add(new Paragraph(" "));

			// Criando uma tabela com 6 colunas
			float[] columnWidths = { 100, 100, 100, 100, 100 };
			Table table = new Table(columnWidths);

			// Cabeçalhos das colunas
			table.addHeaderCell(new Cell().add(new Paragraph("Produtos")));
			table.addHeaderCell(new Cell().add(new Paragraph("Quantidade")));
			table.addHeaderCell(new Cell().add(new Paragraph("Data")));
			table.addHeaderCell(new Cell().add(new Paragraph("Usuario")));
			table.addHeaderCell(new Cell().add(new Paragraph("Tipo de Movimentação")));

			// Populando a tabela com os dados
			for (Moviment mov : lista) {
				for (Product p : mov.getProduct()) {

					table.addCell(new Cell().add(new Paragraph(p.getName())));

				}
				table.addCell(new Cell().add(new Paragraph(String.valueOf(mov.getAmount()))));
				table.addCell(new Cell().add(new Paragraph(String.valueOf(DataUtil.ajustarDataParaBrasil(mov.getDate())))));

			

					table.addCell(new Cell().add(new Paragraph(mov.getUser().getUsername())));

			
				table.addCell(new Cell().add(new Paragraph(String.valueOf(mov.getType()))));
			}

			// Adicionando a tabela ao documento
			document.add(table);

			// Fechando o documento
			document.close();

		} catch (Exception e) {
			
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
