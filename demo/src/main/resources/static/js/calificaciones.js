/**
 * 
 * MISAEL LOPEZ ORTIZ
 * 
 */
let dataCalificacion;

$(function () {

    loadAlumnos();
    loadMaterias();
    loadCalificaciones();

    //Agregar Calificación
    $("#sumbitAdd").submit(function (event) {
        event.preventDefault();
        const fecha = new Date();

        const data = {
			"alumno": {
                "id_t_usuarios": $("#selectAlumno").val()
            },
            "materias": {
                "id_t_materias": $("#selectMateria").val()
            },
            "calificacion": $("#inputCalificacion").val(),
            "fecha_registro": fecha.toISOString()
        }

        $.ajax({
            url: "http://localhost:8080/api/calificaciones/",
            method: "post",
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "json",
            success: function (result) {
                if (result.success === "ok") {
                    loadCalificaciones();
                    loadAlumnos();
    				loadMaterias();
                    $("#inputCalificacion").val('');
                    alert(result.msg);
                } else {
                    console.log(result);
                    alert(resJSON.msg);
                }
            }
        });

    });
    
    //Actualizar Calificación
    $("#sumbitUpd").submit(function (event) {
        event.preventDefault();
        const fecha = new Date();

        const data = {
			"id_t_calificaciones": dataCalificacion.id_t_calificaciones,
			"alumno": {
                "id_t_usuarios": dataCalificacion.id_t_usuarios
            },
            "materias": {
                "id_t_materias": dataCalificacion.id_t_materias
            },
            "calificacion": $("#inputCalificacionUPD").val(),
            "fecha_registro": fecha.toISOString()
        }

        $.ajax({
            url: "http://localhost:8080/api/calificaciones/",
            method: "put",
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "json",
            success: function (result) {
                if (result.success === "ok") {
                    loadCalificaciones();
                    $("#divCardModificar").attr("hidden", "hidden");
                    $("#inputCalificacionUPD").val('');
                    alert(result.msg);
                } else {
                    console.log(result);
                    alert(resJSON.msg);
                }
            }
        });

    });

});

//Cargar Alumnos
function loadAlumnos() {
    $.get("http://localhost:8080/api/alumno/",
        function (res) {
            $("#selectAlumno").empty();
            $("#selectAlumno").append(`<option value="" selected>Seleccionar Alumno</option>`);
            $.each(res, function (idx, el) {
                $("#selectAlumno").append(`<option value=${el.id_t_usuarios}>${el.nombre} ${el.ap_paterno} ${el.ap_materno}</option>`)
            });
        });
}

//Cargar Materias
function loadMaterias() {
    $.get("http://localhost:8080/api/materias/",
        function (res) {
            $("#selectMateria").empty();
            $("#selectMateria").append(`<option value="" selected>Seleccionar Materia</option>`);
            $.each(res, function (idx, el) {
                $("#selectMateria").append(`<option value=${el.id_t_materias}>${el.nombre}</option>`)
            });
        });
}

//Cargar Calificaciones
function loadCalificaciones() {
	$("#tableBodyCalificaciones").empty();
    $.get("http://localhost:8080/api/calificaciones/",
        function (res) {
			if(res.length > 0) {
				$.each(res, function (idx, el) {
                	$("#tableBodyCalificaciones").append(`<tr>
											            <th scope="row">${el.id_t_calificaciones}</th>
											            <td><button type="button" class="btn btn-danger" onClick="deleteCalificacion(${el.id_t_calificaciones})">Eliminar</button></td>
											            <td><button type="button" class="btn btn-primary" onClick="updateCalificacion(${el.id_t_calificaciones})">Modificar</button></td>
											            <td>${el.alumno.nombre} ${el.alumno.ap_paterno} ${el.alumno.ap_materno}</td>
											            <td>${el.materias.nombre}</td>
											            <td>${el.calificacion}</td>
											            <td>${el.fecha_registro}</td>
											          </tr>`)
            	});
			}
			
        });
}

//Modificar calificación
function updateCalificacion(id) {
	
	$.ajax({
            url: "http://localhost:8080/api/calificaciones/" + id,
            method: "get",
            dataType: "json",
            success: function (result) {
                if (result.id_t_calificaciones === id) {
					dataCalificacion = result;
                    $("#divCardModificar").removeAttr("hidden");
                    $("#inputAlumno").val(result.alumno.nombre + " " + result.alumno.ap_paterno + " " + result.alumno.ap_materno);
					$("#inputMateria").val(result.materias.nombre);
                    $("#inputCalificacionUPD").val('');
                    //$("#divCardModificar").attr("hidden", "hidden");
                    $("#inputCalificacionUPD").val('');
                } else {
                    console.log(result);
                }
            }
	});
    
}

//Eliminar calificación
function deleteCalificacion(event) {
	const data = {
            "id_t_calificaciones": event
        }

    $.ajax({
        url: "http://localhost:8080/api/calificaciones/",
        method: "delete",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        success: function (result) {
			console.log(result);
            if (result.success === "ok") {
				loadCalificaciones();
                alert(result.msg);
            } else {
                console.log(result);
                alert(resJSON.msg);
            }
        }
    });
}