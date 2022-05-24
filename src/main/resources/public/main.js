/**
 * 
 */

$('document').ready(function() {

function matchPassword() {
console.log($(".pwd"))
console.log($(".pwd").val())
  if($(".pwd").val() != $(".pwd2").val())
  {
    alert("Passwords did not match");
  } else {
    alert("Registration Complete");
  }
}


	
	$('.table .btn-warning').on('click',function(event){
		
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(student, status){
			$('#IdEdit').val(student.id);
			$('#nameEdit').val(student.name);
			$('#departmentEdit').val(student.department);
			$('#updatedByEdit').val(student.updatedBy);
			$('#updatedOnEdit').val(student.updatedOn.substr(0,10));
		});	
		
		$('#editModal').modal();
		
	});
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
		
	});
	
});