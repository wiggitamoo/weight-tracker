define(["app/setup","app/member","app/weight"], function (Setup,Member,Weight) {
	Setup.init();
	Member.getHeader();
	Weight.click();
});