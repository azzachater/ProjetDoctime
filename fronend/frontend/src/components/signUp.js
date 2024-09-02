import React, { useState,useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
function SignUp() {
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password:'',
    dob: '',
    role: 'patient',
    adress: '',
    experience: '',
  });
  const navigate = useNavigate(); 
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
    
    
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const endpoint = formData.role === 'doctor' ? 'http://localhost:8081/signup-doctor' : 'http://localhost:8081/signup-patient';
    
     //Configuration des en-têtes CORS
    const headers = {
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
      // Vous pouvez également inclure d'autres en-têtes CORS nécessaires ici
    };
  
    // Envoi de la requête avec les en-têtes CORS
    axios.post(endpoint, formData,headers)
      .then(response => {
        if(response.data==="Patient Added successfully" || response.data==="Doctor Added successfully"){
          navigate('/activation');
        }
        else{
          alert(response.data);
        }
      })
      .catch(error => {
        console.error("Erreur lors de l'inscription:", error);
      });
  };
  
   //m 
    useEffect(() => {
        // Sélectionnez les boutons radio et le champ spécifique au médecin
        const patientRadio = document.querySelector('input[value="patient"]');
        const doctorRadio = document.querySelector('input[value="doctor"]');
        const doctorFields = document.getElementById('doctorFields');
    
        // Ajoutez un écouteur d'événements pour les changements de sélection
        patientRadio.addEventListener('change', () => {
          if (patientRadio.checked) {
            // Afficher les champs du patient
            doctorFields.style.display = 'none';
          }
        });
    
        doctorRadio.addEventListener('change', () => {
          if (doctorRadio.checked) {
            // Afficher les champs du médecin
            doctorFields.style.display = 'block';
          }
        });
    
        // Nettoyer l'écouteur d'événements lors du démontage du composant
        return () => {
          patientRadio.removeEventListener('change', () => {});
          doctorRadio.removeEventListener('change', () => {});
        };
      }, []); 
      



    return(
        <>
    <section className="form-02-main">
      <div className="container">
        <div className="row">
          <div className="col-md-12">
            <div className="_lk_de">
              <div className="form-03-main">
                <div className="logo">
                  <img src="assets1/images/user.png"/>
                </div>
                <form onSubmit={handleSubmit}>
                <div className="form-group">
                  <input type="text" name="username" className="form-control _ge_de_ol" placeholder="Enter Username" onChange={handleChange} required="" aria-required="true"/>
                </div>
                <div className="form-group">
                  <input type="email" name="email" className="form-control _ge_de_ol"  placeholder="Enter Email" onChange={handleChange}required="" aria-required="true"/>
                </div>
                <div className="form-group">
                  <input type="date" name="dob" className="form-control _ge_de_ol" onChange={handleChange} required="" aria-required="true"/>
                </div>
                <div className="form-group">
                  <input type="password" name="password" className="form-control _ge_de_ol" onChange={handleChange}placeholder="Enter Password" required="" aria-required="true"/>
                </div>
                <div className="form-group">
                    <input type="radio" name="role"  required="" onChange={handleChange} value="patient" defaultChecked/>
                    <span>Patient</span>
                    <input type="radio" name="role" required="" onChange={handleChange} value="doctor"/>
                    <span>Doctor</span>
                </div>
                <div id="doctorFields" style= {{display: "none"}}>
                <div className="form-group">
                  <input type="text" name="adress" className="form-control _ge_de_ol" placeholder="Enter Address"onChange={handleChange} required="" aria-required="true"/>
                </div>
                <div className="form-group">
                  <input type="number" name="experience" className="form-control _ge_de_ol" placeholder="Experience"onChange={handleChange} required="" aria-required="true"/>
                </div>
                </div>
               
                
                
                <div className="form-group">
                  <div className="_btn_04">
                  <button type="submit" href="/activation" >SignUp</button>
                </div>
              </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
        </>
    
    );
}
export default SignUp;