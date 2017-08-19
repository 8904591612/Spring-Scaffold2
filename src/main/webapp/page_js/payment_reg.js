var endlessScrollingIndex=0;
$(document).ready(function(){
//$('#scrollablePanel').bind('scroll',chk_scroll);
	load_data();
	$('#scrollablePanel').on('scroll', function(){
		
		if($(this).scrollTop() + $(this).innerHeight() >= $(this)[0].scrollHeight) {
			alert("namah Shivaya");
			load_data();
		}
		
		
	});
	
})




function load_data(){
	endlessScrollingIndex=endlessScrollingIndex+10;
	$.ajax({
		type: "GET",
		url:  "/rest/payment_reg/index",
		data: {"endlessScrollingIndex": endlessScrollingIndex},
		success:function(data){
			
			for(i=0; i<data.length; i++){
			$("tbody").append("<tr><td>"+data[i].id+"</td>"+"<td>"+data[i].organisers+"</td>" +"<td>"+data[i].transaction_id+"</td>"
					
					            +"<td>"+data[i].amount+"</td>" + "<td>"+data[i].sbi_ref_no +"</td>"+ "<td>"+data[i].status +"</td>" 
					            +"<td>"+data[i].status_desc +"</td>"
					            +"<td>"+data[i].user_desc +"</td>"
					            + "<td>"+data[i].currency +"</td>"
					            +"</tr>");

			
			}
			
			
		}

		
		
	});
	
	
}








