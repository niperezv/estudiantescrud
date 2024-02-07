import './App.css';
import ListaEstudiantesComponent from "./components/ListaEstudiantesComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import EstudianteComponent from "./components/EstudianteComponent";

function App() {
  return (
      <>
          <BrowserRouter>
              <HeaderComponent />
              <Routes>
                  {/*// http://localhost:3000*/}
                  <Route path='/' element={ <ListaEstudiantesComponent />}></Route>
                  {/*//http://localhost:3000/estudiantes*/}
                  <Route path='/estudiantes' element={ <ListaEstudiantesComponent />}></Route>
                  {/*// http://localhost:3000/add-estudiante*/}
                  <Route path='/add-estudiante' element= { <EstudianteComponent/> }></Route>
                  {/*// http://localhost:3000/edit-estudiante/1 */}
                  <Route path='/edit-estudiante/:id' element={<EstudianteComponent/>}></Route>
              </Routes>
              <FooterComponent/>
          </BrowserRouter>
      </>
  );
}

export default App;
