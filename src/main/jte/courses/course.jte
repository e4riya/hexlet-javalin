@import org.example.hexlet.dto.CoursePage
@param CoursePage page

@template.index(content = @`
    <h1>${page.getCourse().getName()}</h1>
    <p>${page.getCourse().getContent()}</p>
`)
