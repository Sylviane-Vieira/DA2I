<!DOCTYPE HTML>
<HTML>
<HEAD>
   <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <%@ page import="java.sql.*" %>
</HEAD>
<BODY>
<%
   Class.forName("org.postgresql.Driver");
   String url = "jdbc:postgresql://psqlserv/da2i";
   String admin = "vieiras";
   String mp = "moi";
   Connection con = DriverManager.getConnection(url, admin, mp);
   Statement stmt = con.createStatement();
%>
<% List<String> noms = new ArrayList<String>();
noms.add("Jean");
noms.add("Jacques");
pageContext.setAttribute("noms", noms);
%>
<strong>Recherche d'un objet avec scope :</strong>
${requestScope.personne}
<br/><br/>
<strong>Recherche d'un objet sans scope :</strong>
${personne}
<br/><br/>
<strong>Operateur [] :</strong>
${applicationScope["User.Cookie"]}
<br/><br/>
<strong>Usage du . en cascade :</strong>
${sessionScope.employe.adresse.adresse}
<br/><br/>
<strong>Elements d'une liste :</strong>
${noms[1]}
<br/><br/>
<strong>En-tête HTTP :</strong>
${header["Accept-encoding"]}
<br/><br/>
<strong>Cookie utilisateur :</strong>
${cookie["User.Cookie"].value}
<br/><br/>
<strong>Contexe de page :</strong>
HTTP Method is ${pageContext.request.method}
<br/><br/>
<strong>Accès aux params du contexte :</strong>
${initParam.AppID}
<br/><br/>
<strong>Operateur arithmétique :</strong>
${initParam.AppID + 200}
<br/><br/>
<strong>Operateur de comparaison :</strong>
${initParam.AppID < 200}
<br/><br/>

</BODY>
</HTML>
