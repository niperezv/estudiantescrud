import React, {useEffect, useState} from "react";
import Modal from "bootstrap/js/src/modal";
import {createEstudiante, getEstudiante, updateEstudiante} from "../services/EstudianteServicio";
import {useNavigate, useParams} from "react-router-dom";

const EstudianteComponent = () => {
    const [correo_institucional, setCorreoInstitucional] = useState('');
    const [tipo_de_documento, setTipoDeDocumento] = useState('');
    const [numero_de_documento, setNumeroDeDocumento] = useState('');
    const [nombre, setNombre] = useState('');
    const [apellido, setApellido] = useState('');
    const [facultad, setFacultad] = useState('');
    const [programa, setPrograma] = useState('');
    const [sede, setSede] = useState('');
    const [vinculo, setVinculo] = useState('');

    const {id } = useParams();
    const navigator = useNavigate();

    useEffect(() => {
        if (id) {
            getEstudiante(id).then((response) => {
                const estudiante = response.data;
                setCorreoInstitucional(estudiante.correo_institucional);
                setTipoDeDocumento(estudiante.tipo_de_documento);
                setNumeroDeDocumento(estudiante.numero_de_documento);
                setNombre(estudiante.nombre);
                setApellido(estudiante.apellido);
                setFacultad(estudiante.facultad);
                setPrograma(estudiante.programa);
                setSede(estudiante.sede);
                setVinculo(estudiante.vinculo);
            }).catch(error => {
                console.error(error);
            });
        }
    }, [id]);

    const saveEstudiante = (e) => {
        e.preventDefault();
        const estudiante = {
            correo_institucional,
            tipo_de_documento,
            numero_de_documento,
            nombre,
            apellido,
            facultad,
            programa,
            sede,
            vinculo
        };

        if (id) {
            updateEstudiante(id, estudiante).then((response) => {
                console.log(response.data);
                navigator('/estudiantes');
            }).catch(error => {
                console.error(error);
            });
        } else {
            createEstudiante(estudiante).then((response) => {
                console.log(response.data);
                navigator('/estudiantes');
            }).catch(error => {
                console.error(error);
            });
        }
    };

    function pageTitle() {
        if (id) {
            return <h2 className='text-center'>Editar Estudiante</h2>;
        } else {
            return <h2 className='text-center'>Agregar estudiante</h2>;
        }
    }

    return (
        <div className='container'>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    {pageTitle()}
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Correo Institucional:</label>
                                <input
                                    type='text'
                                    placeholder='Ingresa tu correo institucional'
                                    name='correo_institucional'
                                    value={correo_institucional}
                                    className='form-control'
                                    onChange={(e) => setCorreoInstitucional(e.target.value)}
                                />
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Tipo de Documento:</label>
                                <input
                                    type='text'
                                    placeholder='Ingresa tu tipo de documento'
                                    name='tipo_de_documento'
                                    value={tipo_de_documento}
                                    className='form-control'
                                    onChange={(e) => setTipoDeDocumento(e.target.value)}
                                />
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Número de Documento:</label>
                                <input
                                    type='text'
                                    placeholder='Ingresa tu número de documento'
                                    name='numero_de_documento'
                                    value={numero_de_documento}
                                    className='form-control'
                                    onChange={(e) => setNumeroDeDocumento(e.target.value)}
                                />
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Nombre:</label>
                                <input
                                    type='text'
                                    placeholder='Ingresa tu nombre'
                                    name='nombre'
                                    value={nombre}
                                    className='form-control'
                                    onChange={(e) => setNombre(e.target.value)}/>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Apellido:</label>
                                <input
                                    type='text'
                                    placeholder='Ingresa tu apellido'
                                    name='apellido'
                                    value={apellido}
                                    className='form-control'
                                    onChange={(e) => setApellido(e.target.value)}/>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Facultad:</label>
                                <input
                                    type='text'
                                    placeholder='Ingresa tu facultad'
                                    name='facultad'
                                    value={facultad}
                                    className='form-control'
                                    onChange={(e) => setFacultad(e.target.value)}
                                />
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Programa:</label>
                                <input
                                    type='text'
                                    placeholder='Ingresa tu programa'
                                    name='programa'
                                    value={programa}
                                    className='form-control'
                                    onChange={(e) => setPrograma(e.target.value)}
                                />
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Sede:</label>
                                <input
                                    type='text'
                                    placeholder='Ingresa tu sede'
                                    name='sede'
                                    value={sede}
                                    className='form-control'
                                    onChange={(e) => setSede(e.target.value)}
                                />
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'>Vínculo:</label>
                                <input
                                    type='text'
                                    placeholder='Ingresa tu vínculo'
                                    name='vinculo'
                                    value={vinculo}
                                    className='form-control'
                                    onChange={(e) => setVinculo(e.target.value)}
                                />
                            </div>
                            <button className='btn btn-success' onClick={saveEstudiante}>Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default EstudianteComponent;
