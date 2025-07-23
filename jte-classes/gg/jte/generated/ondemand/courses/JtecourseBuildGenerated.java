package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.BuildCoursePage;
public final class JtecourseBuildGenerated {
	public static final String JTE_NAME = "courses/courseBuild.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,3,3,4,4,6,6,7,7,8,8,8,9,9,10,10,12,12,17,17,17,17,17,17,17,17,17,23,23,23,29,29,29,34,34,34,35,35,35,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildCoursePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JteindexGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    ");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\n        <ul>\n            ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\n                ");
						for (var error : validator) {
							jteOutput.writeContent("\n                    <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\n                ");
						}
						jteOutput.writeContent("\n            ");
					}
					jteOutput.writeContent("\n        </ul>\n    ");
				}
				jteOutput.writeContent("\n    <form action=\"/courses\" method=\"post\">\n        <div>\n            <label>\n                Название курса\n                <input type=\"text\" required name=\"name\"");
				var __jte_html_attribute_0 = page.getCourse() != null ? page.getCourse().getName() : "";
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" />\n            </label>\n        </div>\n        <div>\n            <label>\n                Описание\n                <textarea required name=\"description\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(page.getCourse() != null ? page.getCourse().getDescription() : "");
				jteOutput.writeContent("</textarea>\n            </label>\n        </div>\n        <div>\n            <label>\n                Материал\n                <textarea required name=\"content\">");
				jteOutput.setContext("textarea", null);
				jteOutput.writeUserContent(page.getCourse() != null ? page.getCourse().getContent() : "");
				jteOutput.writeContent("</textarea>\n            </label>\n        </div>\n        <input type=\"submit\" value=\"Добавить курс\" />\n    </form>\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildCoursePage page = (BuildCoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
