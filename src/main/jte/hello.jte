@import org.example.hexlet.NamedRoutes

@template.index(
    content = @`
    <p><a href="${NamedRoutes.coursesPath()}">Курсы</a></p>
    `
)