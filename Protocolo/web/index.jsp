<%@page import="org.axocode.dao.protocol"%>
<%@page import="org.axocode.service.dao.protocolService"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="css/maincss.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
        <title>Protocolo</title>
        <link rel="icon" type="image/jpg" href="images/favicon.jpg"/>
    </head>
            <%
            String contra = null;
            String usuario = null;
            int solicitud;
            usuario = request.getParameter("IUser");
            contra = request.getParameter("IContra");
            %>
    <body>
        <%if (usuario==null) {
                %>
            <h1>Ingrese sus datos</h1>
            <form>
        <div class="input-field">
                <input id="IContra" name="IUser" value="" type="text" class="input"  minlength="6" maxlength="100" required/>
                <label for="user">Nombre de Usuario</label>
            </div>
            <div class="input-field">
                <input id="IAge" name="IPass" value="" type="password" class="input" required   maxlength="20"  />
                <label for="edad">Contraseña</label>           
            </div>
            <div class="input-field">
                <input id="accion" type="hidden" value="Guardar" name="accion"  class="submit" value="${param.accion}">
                <input id="action" type="submit" value="Enviar" name="action" class="submit" value="${param.accion}"> 
            </div>
    </form>
        <%
            }
        %>
        
            
        <%
            
            
 
            if (usuario!=null) {
            

        String IUser = request.getParameter("IUser");
        String IPass = request.getParameter("IPass");

        protocolService.Resultados eco = protocolService.eco(new protocol(IUser, IPass));
        
        StringBuilder ecoUsuario = eco.resultado1;
        StringBuilder ecoPassword = eco.resultado2;
        
        
        
        solicitud = 111;
        protocolService conector = new protocolService();
            boolean registroE = conector.convey(ecoUsuario.toString(), ecoUsuario.toString(), ecoPassword.toString(), ecoPassword.toString());
            if (registroE) {
                    solicitud =113;
                }
                else{
                    solicitud = 111;
            }
        
                %>
            <h1>Eco: <%=usuario%> = <%=ecoUsuario%></h1>
            <h1><%=solicitud%></h1>
            <br>
            <h1>User y password</h1>
            
            
            
            <%
            protocol give = conector.trow(ecoUsuario.toString(), ecoUsuario.toString());
            
            
            
            protocolService.Resultados deco = protocolService.deco(new protocol(give.getIUser(), give.getIPass()));


            StringBuilder decoUsuario = deco.resultado1;
            StringBuilder decoPassword = deco.resultado2;
            
            %>
            <br>
            <h1>Datos <%=give.getIUser()%> y <%=give.getIPass()%></h1>
            <h1>Deco: <%=decoUsuario%> Y <%=decoPassword%></h1>
            
            <h1><a href="index.jsp">regresar</a></h1>
            
        <%  
            }
        %>
    
    </body>
</html>
