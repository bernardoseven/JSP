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
                            <a class="navbar-brand" href="index.jsp">Peluquería PeloDuro</a>
                        </div>
                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="#">Home</a></li>
                                <li><a href="registro.jsp">Registro de Usuario</a></li>
                                <li><a href="atencion.jsp">Solicita Atención</a></li>
                                <li><a href="reporte.jsp">Reporte de Atenciones</a></li>
                                <li><a href="login.jsp">Login</a></li>
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
                    <h1>Reporte Cita Agendada</h1>
                    <form action="BuscarCitaAgendada">
                        <input type="date" name="txtFecha" />
                        <input type="hidden" name="op" value="BuscarCitaAgendada">
                        <input type="submit" value="Buscar" />
                    </form> 
                    <br />
                    <h1>Reporte Cita Realizada</h1>
                    <form action="BuscarCitaRealizada">
                        <input type="date" name="txtFecha" />
                        <input type="hidden" name="op" value="BuscarCitaRealizada">
                        <input type="submit" value="Buscar" />
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