define([], function () {
	console.log("member!")
	
	function getHeader() {
		$.get( "MemberInfo", function( members ) {
			for(var member in members) {
				console.log(members[member].firstname);
				console.log(members[member].lastname);
				console.log(members[member].age);		
				
				$("#weightTrackerNav ul").append("<li><a href='#"+members[member].firstname+"'>"+members[member].firstname+"</a></li>");
			}
		  
		});
	}
	
	return {
		getHeader:getHeader
	};
});
