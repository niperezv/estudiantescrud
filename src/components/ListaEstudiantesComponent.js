import React, {useEffect, useState} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import {deleteEstudiante, listaEstudiantes} from "../services/EstudianteServicio";
import {useNavigate} from 'react-router-dom'

 const ListaEstudiantesComponent = () => {

     const [estudiante, setEstudiante] = useState([])

     const navigator = useNavigate();
     useEffect(() => {
         getAllEstudiante();

     }, []);

     function getAllEstudiante() {
         listaEstudiantes().then((response) =>{
             setEstudiante(response.data);
         }).catch(error => {
             console.error(error);
         })
     }

     function CreateNewEstudiante() {
         navigator('/add-estudiante')

     }

     function editEstudiante(id) {
         navigator(`/edit-estudiante/${id}`)
     }

     function removeEstudiante(id) {
         deleteEstudiante(id).then((response) => {
             getAllEstudiante()
         }).catch(error => {
             console.error(error);
         })
         console.log(id)
     }

     return (
         <div className='container-md'>
             <h2 className='text-center mb-4 mt-4'>Lista de estudiantes</h2>
             <button type='button' className='btn btn-primary mb-2' onClick={CreateNewEstudiante}>Add Estudiante</button>
             <table className='table table-striped table-bordered table-hover table-dark'>
                 <thead className='thead-dark'>
                    <tr>
                        <th>Id</th>
                        <th>Correo</th>
                        <th>Tipo documento</th>
                        <th>Numero documento</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Facultad</th>
                        <th>Programa</th>
                        <th>Sede</th>
                        <th>Vinculo</th>
                        <th>Actions</th>
                    </tr>
                 </thead>
                 <tbody>
                    {
                        estudiante.map(estudiante =>
                        <tr key={estudiante.id}>
                            <td>{estudiante.id}</td>
                            <td>{estudiante.correo_institucional}</td>
                            <td>{estudiante.tipo_de_documento}</td>
                            <td>{estudiante.numero_de_documento}</td>
                            <td>{estudiante.nombre}</td>
                            <td>{estudiante.apellido}</td>
                            <td>{estudiante.facultad}</td>
                            <td>{estudiante.programa}</td>
                            <td>{estudiante.sede}</td>
                            <td>{estudiante.vinculo}</td>
                            <td>
                                <button className='btn btn-info' onClick={() => editEstudiante(estudiante.numero_de_documento)}>Edit</button>
                                <button className='btn btn-danger' onClick={() => removeEstudiante(estudiante.numero_de_documento)}
                                style={{marginLeft: '10'}}>Delete</button>
                            </td>
                        </tr>)
                    }
                 </tbody>
             </table>
         </div>
     )
 }

 export default ListaEstudiantesComponent