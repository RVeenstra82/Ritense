<%@ include file="common/header.jspf"%>

<div class="container">
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Wat voor brood wil je voor je ${burgerName}</h3>
		</div>
		<div class="dropdown">
  			<button class="dropbtn">Kies:</button>
  			<c:forEach items="${breads}" var="bread">
    			<a href="#">${bread.toString}</a>
    		</c:forEach>
  		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>