<%@page import="peloduro.modelo.Cita"%>
<%@page import="java.util.ArrayList"%>
<%@page import="peloduro.DAO.DaoCita"%>
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
    <%
        DaoCita Daocit = new DaoCita();
        ArrayList<Cita> lstCita = Daocit.ListaCitaRealizada();
        %>
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
                <div class="col-md-12">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Fecha</th>
                                <th>Hora</th>
                                <th>Cliente</th>
                                <th>Empleado</th>
                                <th>Requerimiento</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <% for (Cita cit : lstCita) {%>
                                <td><%= cit.getFecha()%></td>
                                <td><%= cit.getHora()%></td>
                                <td><%= cit.getCliente()%></td>
                                <td><%= cit.getEmpleado()%></td>
                                <td><%= cit.getRequerimiento()%></td>
                              </td>                
                            </tr>
                            <% }%>
                        </tbody>
                    </table>

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