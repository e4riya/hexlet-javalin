@import org.example.hexlet.Courses.Course
@import java.util.List
@param List<Course> page
@param String header

<html>
    <head>
        <title>Хекслет</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h1>${header}</h1>
        @if(page.isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var course : page)
               <div>
                   <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
                   <p>${course.getDescription()}</p>
               </div>
            @endfor
        @endif
    </body>
</html>