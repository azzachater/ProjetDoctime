import React, { useEffect } from 'react';

function SignUp() {
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
    <section class="form-02-main">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="_lk_de">
              <div class="form-03-main">
                <div class="logo">
                  <img src="assets1/images/user.png"/>
                </div>
                <div class="form-group">
                  <input type="text" name="username" class="form-control _ge_de_ol" placeholder="Enter Username" required="" aria-required="true"/>
                </div>
                <div class="form-group">
                  <input type="email" name="email" class="form-control _ge_de_ol"  placeholder="Enter Email" required="" aria-required="true"/>
                </div>
                <div class="form-group">
                  <input type="date" name="dob" class="form-control _ge_de_ol"  required="" aria-required="true"/>
                </div>
                <div class="form-group">
                  <input type="password" name="password" class="form-control _ge_de_ol" placeholder="Enter Password" required="" aria-required="true"/>
                </div>
                <div class="form-group">
                    <input type="radio" name="userType"  required="" aria-required="true" value="patient" checked/>
                    <span>Patient</span><br/>
                    <input type="radio" name="userType" required="" aria-required="true" value="doctor"/>
                    <span>Doctor</span>
                </div>
                <div id="doctorFields" style= {{display: "none"}}>
                <div class="form-group">
                  <input type="text" name="address" class="form-control _ge_de_ol" placeholder="Enter Address" required="" aria-required="true"/>
                </div>
                <div class="form-group">
                  <input type="number" name="experience" class="form-control _ge_de_ol" placeholder="Experience" required="" aria-required="true"/>
                </div>
                </div>
               
                
                <div class="form-group">
                  <div class="_btn_04">
                    <a href="#">SignUp</a>
                  </div>
                </div>
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