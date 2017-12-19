

<!DOCTYPE HTML>
<HTML>
<HEAD>
  <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Ajax1</title>
  <script language="javascript" type="text/javascript">
  req = new XMLHttpRequest();
  function appel(){
    req.open("GET", "data.txt", true);
    req.onreadystatechange = retour;
    req.send(null);
  }
  function retour(){
    document.getElementById('nom').value = req.responseText;
  }
  </script>
  <script language="javascript" type="text/javascript">
  </script>

</HEAD>
<BODY>
  <%! int cpt=0; %>
  <%= cpt++ %>
  <form name="form">
    entrez le nom
    <input type="text" size="20" name="nom" id="nom"/>
    <br>
   <input type="button" value="download" onclick="appel()"/>
   </form>



</BODY>
</HTML>
