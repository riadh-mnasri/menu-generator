<%--
  Created by IntelliJ IDEA.
  User: riadh
  Date: 30/04/15
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body>
<%--<c:url value="/resources/text.txt" var="url"/>
<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
Spring URL: ${springUrl} at ${time}--%>
<h1>${message} at ${time}</h1>

<form:form method="POST" commandName="recetteForm" action="/gmf/add">
  <form:errors path="*" cssClass="errorblock" element="div" />
  <table>
    <tr>
      <td>Num&eacute;ro recette :</td>
      <td><form:input path="id" />
      </td>
    </tr>
    <tr>
      <td>Nom recette :</td>
      <td><form:input path="recetteName" />
      </td>
    </tr>
    <tr>
      <td colspan="3"><input type="submit" />
      </td>
    </tr>
  </table>
</form:form>
</body>

</html>
