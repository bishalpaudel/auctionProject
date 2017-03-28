
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!----footer--->
<div class="footer">
	<div class="container">
		<div class="col-md-3 footer-logo">
			<a href="index.html"><img src="${pageContext.request.contextPath}/resource/frontend/images/logo.png"
				title="brand-logo" height = "40px"/></a>
		</div>
		<div class="col-md-7 footer-links">
			<ul class="unstyled-list list-inline">
				<li><a href="#">&copy; Copyright 2017 Himalayan Auction</a> <span> </span></li>
				
				<div class="clearfix"></div>
			</ul>
		</div>
		<div class="col-md-2 footer-social">
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div class="clearfix"></div>
<!---//footer--->
<!---copy-right--->
<div class="copy-right">
	<div class="container">
		
		<script type="text/javascript">
			$(document).ready(function() {
				/*
				var defaults = {
					containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
				};
				 */

				$().UItoTop({
					easingType : 'easeOutQuart'
				});

			});
		</script>
		<a href="#" id="toTop" style="display: block;"> <span
			id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
</div>
<!--//copy-right--->
</div>
<!----container---->