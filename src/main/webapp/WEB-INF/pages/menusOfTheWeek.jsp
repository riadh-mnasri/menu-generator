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

<c:if test="${not empty recettes}">
  <div id="menu-list">
    <table class="table table-striped table-bordered table-condensed" border="1">
      <tr>
        <th>Jour</th>
        <th>Nom Recette</th>
      </tr>
      <c:forEach items="${recettes}" var="recette">
        <tr>
          <td>${recette.key}</td>
          <td>${recette.value}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</c:if>
</body>

</html>
