// Подсвечивание кнопок основной горизонтальной шапки
document.addEventListener("DOMContentLoaded", function() {

	var currentPage = document.getElementById("currentPage").value;
	var buttons = document.querySelectorAll('button[name="colorButton"]');

	buttons.forEach(function(button) {
		if (button.getAttribute("id") === currentPage) {
			button.classList.add("active");
			button.addEventListener("mouseover", function() {
				button.style.backgroundColor = "#707070";
			});
			button.addEventListener("mouseout", function() {
				button.style.backgroundColor = "555";
			});
		}
	});
});

// Подсвечивание кнопок дополнительной вертикальной шапки
document.addEventListener("DOMContentLoaded", function() {

	var filter = document.getElementById("currentFilter").value;
	var buttons = document.querySelectorAll('button[name="filterButton"]');

	buttons.forEach(function(button) {
		if (button.getAttribute("id") === filter) {
			button.classList.add("active");
			button.addEventListener("mouseover", function() {
				button.style.backgroundColor = "#888";
			});

			button.addEventListener("mouseout", function() {
				button.style.backgroundColor = "#555";
			});
		}
	});
});