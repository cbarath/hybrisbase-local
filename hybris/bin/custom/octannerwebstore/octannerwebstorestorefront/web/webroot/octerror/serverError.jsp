<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<%@page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
      <title>Server Error</title>
      <style>
        .body {
          background-image: url("");
          -webkit-background-size: cover;
          -moz-background-size: cover;
          -o-background-size: cover;
          background-size: cover;
        }
        h1 {color: red}
        h2 {color: white; size = 10px}
        p {color: white; size: 10px}
      </style>
    </head>
    <body class="body">
    <div class="container" align="middle">
      <div class="row">
        <div class="col-md-12">
          <div class="error-template">
            <h1>Oops!</h1>
            <h2>Page Not Found</h2>
            <div class="error-details">
              <p>Sorry, an error has occured, Requested page not found!</p>
            </div>
            <div class="error-actions">
              <a href="http://localhost:9001/octannerwebstorestorefront/?site=powertools" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                Take Me Home </a>
              <!-- <a href="" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Contact Support </a> -->
            </div>
          </div>
        </div>
      </div>
    </div>
    </body>
</html>