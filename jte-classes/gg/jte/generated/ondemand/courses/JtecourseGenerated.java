package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.CoursePage;
public final class JtecourseGenerated {
	public static final String JTE_NAME = "courses/course.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JteindexGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1>");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getCourse().getName());
				jteOutput.writeContent("</h1>\n    <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(page.getCourse().getContent());
				jteOutput.writeContent("</p>\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
