
// import './App.css';
import { BrowserRouter, Route,Routes } from 'react-router-dom';
import FooterComponent from './Components/FooterComponent';
import HeaderComponent from './Components/HeaderComponent';
import ListEmployeeComponent from './Components/ListEmployeeComponent';
import AddEmployeeComponent from './Components/AddEmployeeComponent';

function App() {
  return (
    <div className='App' >
      <HeaderComponent/>
    <BrowserRouter>
     <Routes>
      <Route  path='/employee' element={<ListEmployeeComponent/>}/>
      <Route path='/' element={<ListEmployeeComponent/>}/>
      <Route path='/add-employee' element={<AddEmployeeComponent/>}/>
      <Route path='/edit-employee/:id' element={<AddEmployeeComponent/>}/>
      <Route path='/delete-employee/:id' element={<ListEmployeeComponent/>}/>

      
     </Routes>
    </BrowserRouter>
    <FooterComponent/>
      
    </div>
  );
}

export default App;

{/* <HeaderComponent/>
<ListEmployeeComponent/>
<FooterComponent/> */}
