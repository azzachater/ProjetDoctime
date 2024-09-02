import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import { Component } from 'react';
import Accueil from './components/accueil';
import SignUp from './components/signUp';
import Doctors from './components/BestDoctors';
import SignIn from './components/signIn';
import Activation from './components/activation';
import Department from './components/departement';
import SpecialityPage from './components/doctorListBySpeciality';
import Appointment from './components/appointment';
import Comment from './components/comment';

function App() {
  return (
      <div className="App">
        <Routes>
          <Route path='/'element={<Accueil/>}/>
          <Route path='/signUp'element={<SignUp/>}/>
          <Route path='/signIn'element={<SignIn/>}/>
          <Route path='/activation'element={<Activation/>}/>
          <Route path='/department'element={<Department/>}/>
          <Route path="/speciality/:speciality" element={<SpecialityPage />} />
          <Route path='/Appointment'element={<Appointment/>}/>
          <Route path='/Comment'element={<Comment/>}/>

        </Routes>
      
      
      </div>
    
    
    
  );
}

export default App;
