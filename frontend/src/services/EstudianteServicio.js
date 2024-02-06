import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/estudiantes';

export const listaEstudiantes = () => axios.get(REST_API_BASE_URL);

export const createEstudiante = (estudiante) => axios.post(REST_API_BASE_URL, estudiante);

export const getEstudiante = (id) => axios.get(REST_API_BASE_URL + '/' + id);

export const updateEstudiante = (estudianteid, estudiante) => axios.put(REST_API_BASE_URL + '/' + estudianteid, estudiante);

export const deleteEstudiante = (estudianteid) => axios.delete(REST_API_BASE_URL + '/' + estudianteid);

