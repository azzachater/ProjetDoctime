import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import BestDoctors from './BestDoctors.js';
const SpecialityPage = () => {
  const { speciality } = useParams();
  const [doctors, setDoctors] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchDoctorsBySpeciality = async () => {
      try {
        const token = localStorage.getItem('bearer');
        const response = await axios.get(`http://localhost:8081/speciality/${speciality}`,{
            headers: {
              Authorization: `Bearer ${token}` // Ajouter le jeton d'authentification dans l'en-tête de la requête
            }
      });
        console.log("1111111");
        setDoctors(response.data);
        setLoading(false);
      } catch (error) {
        setError('Une erreur s\'est produite lors de la récupération des médecins.'+speciality);
        setLoading(false);
      }
    };

    fetchDoctorsBySpeciality();
  }, [speciality]);

  if (loading) {
    return <div>Chargement en cours...</div>;
  }

  if (error) {
    return <div>Erreur : {error}</div>;
  }

  return (
    <>
      {doctors.length > 0 ? (
        <div className="row">
          {doctors.map(doctor => (
            <div key={doctor.userid} className="col-md-6 col-lg-3 ftco-animate">
              <div className="staff">
                <div className="img-wrap d-flex align-items-stretch">
                  <div className="img align-self-stretch" style={{backgroundImage: "url('assets/images/doc-1.jpg')"}}></div>
                </div>
                <div className="text pt-3 text-center">
                  <h3 className="mb-2">Dr. {doctor.username}</h3>
                  <span className="position mb-2">{speciality}</span>
                  <div className="faded">
                    <p>I am an ambitious workaholic, but apart from that, pretty simple person.</p>
                    <ul className="ftco-social text-center">
                      <li className="ftco-animate"><a href="#"><span className="icon-twitter"></span></a></li>
                      <li className="ftco-animate"><a href="#"><span className="icon-facebook"></span></a></li>
                      <li className="ftco-animate"><a href="#"><span className="icon-google-plus"></span></a></li>
                      <li className="ftco-animate"><a href="#"><span className="icon-instagram"></span></a></li>
                    </ul>
                    <p><a href="/Appointment" className="btn btn-primary">Book now</a></p>
                  </div>
                </div>
              </div>
            </div>
          ))}
        </div>
      ) : (
        <div>Aucun médecin trouvé pour cette spécialité.</div>
      )}
    </> 
  );
}

export default SpecialityPage;