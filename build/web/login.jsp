<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Peluqueria Peloduro</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="navbar-wrapper">
            <div class="container">
                <div class="navbar navbar-inverse navbar-static-top" role="navigation">
                    <div class="container">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">Peluquería PeloDuro</a>
                        </div>
                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="registro.jsp">Registro de Usuario</a></li>
                                <li><a href="#contact">Contact</a></li>
                                <li><a href="#contact">Contact</a></li>
                                <li class="active"><a href="login.jsp">Login</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                </div>
                <div class="col-md-4">
                    <form action="IniciarSesion" name="login" class="form-horizontal">
                        <h1>Ingreso</h1>
                        <label>Rut</label>
                        <input name="txtRut" class="form-control input-sm" type="text" />
                        <label>Contraseña</label>
                        <input name="txtPass" class="form-control input-sm" type="text" />
                        <input type="hidden" name="op" value="Login">
                         <br /> 
                        <button type="submit" class="btn btn-primary btn-lg btn-block">Ingresar</button>
                    </form>
                    <form action="CerrarSesion">
                        <input type="hidden" name="op" value="Logout">
                        <input type="submit" value="Cerrar Sesión" name="btnCerrar" />
                    </form>
                </div>
                <div class="col-md-4">
                </div>
            </div>
        </div>






        <div class="container marketing">
            <footer>
                <p>&copy; 2014 Company, Inc. &middot; </p>
            </footer>
        </div>
    </body>
</html>