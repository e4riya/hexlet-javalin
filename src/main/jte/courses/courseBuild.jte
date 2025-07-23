@import org.example.hexlet.dto.BuildCoursePage
@param BuildCoursePage page

@template.index(content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
    <form action="/courses" method="post">
        <div>
            <label>
                Название курса
                <input type="text" required name="name" value="${page.getCourse() != null ? page.getCourse().getName() : ""}" />
            </label>
        </div>
        <div>
            <label>
                Описание
                <textarea required name="description">${page.getCourse() != null ? page.getCourse().getDescription() : ""}</textarea>
            </label>
        </div>
        <div>
            <label>
                Материал
                <textarea required name="content">${page.getCourse() != null ? page.getCourse().getContent() : ""}</textarea>
            </label>
        </div>
        <input type="submit" value="Добавить курс" />
    </form>
`)
