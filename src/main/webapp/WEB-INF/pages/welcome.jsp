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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<body>
<%--<c:url value="/resources/text.txt" var="url"/>
<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
Spring URL: ${springUrl} at ${time}--%>
<h1>${message} at ${time}</h1>

<form:form method="POST" commandName="recetteForm" action="/gmf/recette/save">
  <form:errors path="*" cssClass="errorblock" element="div" />
  <table>
    <c:if test="${not empty recetteForm.id}">
    <tr>
      <td>Num&eacute;ro recette :</td>
      <td><form:input path="id" />
      </td>
    </tr>
    </c:if>
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
<c:if test="${not empty recettes}">
 <div id="menu-list">
  <table class="table table-striped table-bordered table-condensed" border="1">
    <tr>
      <th>Num&eacute;ro Recette</th>
      <th>Nom Recette</th>
      <th>&nbsp;</th>
    </tr>
    <c:forEach items="${recettes}" var="recette">
      <tr>
        <td>${recette.id}</td>
        <td>${recette.recetteName}</td>
        <td><a href='${pageContext.request.contextPath}/gmf/recette/edit/${recette.id}'
               class="btn btn-primary">edit</a>
          <a href='${pageContext.request.contextPath}/gmf/recette/delete/${recette.id}'
             class="btn">Supprimer</a></td>
      </tr>
    </c:forEach>
  </table>
 </div>
</c:if>
</body>

</html>
