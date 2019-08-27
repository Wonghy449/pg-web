<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Hello World!</h2>
Excel upload test
<form action="/recruiting/upload" method="post" enctype="multipart/form-data">
    Candidate<input type="file" name="candidate"><br>
    Interviewer<input type="file" name="interviewer"><br>
    Recruiting<input type="file" name="recruiting"><br>
    <input type="submit" value="upload">
</form>
</body>
</html>
