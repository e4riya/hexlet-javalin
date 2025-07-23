@import org.example.hexlet.NamedRoutes
@import org.example.hexlet.dto.CoursesPage
@param CoursesPage page

@template.index(
    content = @`
    <form action="/courses" method="get">
        <input type="search" required name="term" value="${page.getTerm()}">
        <input type="submit" value="Искать">
    </form>
    @if(page.getCourses() != null && !page.getCourses().isEmpty())
        @for(var course : page.getCourses())
            <div>
                <p><a href="${NamedRoutes.coursePath(course.getId())}">${course.getName()}</a></p>
                <p>${course.getDescription()}</p>
            </div>
        @endfor
    @else
        <p>Курсов не добавлено</p>
    @endif
    <a href="${NamedRoutes.buildCoursePath()}">Добавить новый курс</a>
`)
