<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script
	src='<spring:url value="/resource/frontend/js/jquery-1.12.1.js"></spring:url>'></script>
<script
	src='<spring:url value="/resource/frontend/bootstrap/js/bootstrap.js"></spring:url>'></script>
	<script
	src='<spring:url value="/resource/js/moment.js"></spring:url>'></script>
	<script
	src='<spring:url value="/resource/frontend/bootstrap-datepicker/js/bootstrap-datetimepicker.min.js"></spring:url>'></script>
	
<script
	src='<spring:url value="/resource/frontend/bootstrap-datepicker/js/bootstrap-datepicker.js"></spring:url>'></script>
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/resource/frontend/bootstrap/css/bootstrap.css"></spring:url>'>
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/resource/frontend/bootstrap-datepicker/css/bootstrap-datepicker.css"></spring:url>'>

<link
	href='<spring:url value="/resource/frontend/css/bootstrap.css"></spring:url>'
	rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<!-- Custom Theme files -->
<link
	href='<spring:url value="/resource/frontend/css/style.css"></spring:url>'
	rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!---- start-smoth-scrolling---->
<script type="text/javascript"
	src='<spring:url value="/resource/frontend/js/move-top.js"></spring:url>'></script>
<script type="text/javascript"
	src='<spring:url value="/resource/frontend/js/easing.js"></spring:url>'></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!---- start-smoth-scrolling---->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
</script>
<!----webfonts--->
<link
	href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
	rel='stylesheet' type='text/css'>
<!---//webfonts--->
<!----start-top-nav-script---->
<style>
.top-row {
	margin-top: 0px;
}
</style>
<script>
	$(function() {
		var pull = $('#pull');
		menu = $('nav ul');
		menuHeight = menu.height();
		$(pull).on('click', function(e) {
			e.preventDefault();
			menu.slideToggle();
		});
		$(window).resize(function() {
			var w = $(window).width();
			if (w > 320 && menu.is(':hidden')) {
				menu.removeAttr('style');
			}
		});
	});
</script>
<!----//End-top-nav-script---->