<%@page import="peloduro.modelo.Cliente"%>
<%@page import="peloduro.modelo.Requerimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="peloduro.DAO.DAORequerimiento"%>
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
        DAORequerimiento DaoReq = new DAORequerimiento();
        ArrayList<Requerimiento> lstReq = new ArrayList();
        lstReq = DaoReq.ListarRequerimiento();  
        Cliente cli= new Cliente();
        cli = (Cliente) request.getAttribute("cliente");
        %>
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
                                <li><a href="registro.jsp">Registro de Usuario</a></li>
                                <li class="active"><a href="atencion.jsp">Solicita Atención</a></li>
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
                    <form action="AgregarCita" name="cita" class="form-horizontal">
                        <h1>Solicitar Atención</h1>
                        <label>Rut Usuario</label>
                        <input name="txtRut" class="form-control input-sm" type="text" />
                        <label>Fecha</label>
                        <input name="txtFecha" class="form-control input-sm" type="date" />
                        <label>Hora</label>
                        <select name="cmbHora" class="form-control input-sm">
                            <option selected disabled>Seleccione...</option>
                            <option>11:00</option>
                            <option>11:15</option>
                            <option>11:30</option>
                            <option>11:45</option>
                            <option>12:00</option>
                            <option>12:15</option>
                            <option>12:30</option>
                            <option>13:00</option>
                            <option>16:00</option>
                            <option>16:15</option>
                            <option>16:30</option>
                            <option>16:45</option>
                            <option>17:00</option>
                        </select>
                        <label>Empleado</label>
                        <select name="cmbEmpleado" class="form-control input-sm">
                            <option selected disabled>Seleccione...</option>
                            <option>Empleado1</option>
                            <option>Empleado2</option>
                            <option>Empleado3</option>
                        </select>
                        <label>Requerimiento</label>
                        <select name="cmbRequerimiento" class="form-control input-sm">
                            <option selected disabled>Seleccione...</option>
                            <% for (Requerimiento req : lstReq) {%>
                            <option value="<%=req.getRequerimiento()%>"><%=req.getDescripcion()%></option>
                            <% } %>
                        </select>
                        <input type="hidden" name="op" value="IngresarCita">
                         <br /> 
                        <button type="submit" class="btn btn-primary btn-lg btn-block">Ingresar</button>
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