import React from "react";
import { NavLink } from 'react-router-dom';

const departments = [
  { speciality: "Neurology", description: "Far far away, behind the word mountains" },
  { speciality: "Surgical", description: "Far far away, behind the word mountains" },
  { speciality: "Dental", description: "Far far away, behind the word mountains" },
  { speciality: "Opthalmology", description: "Far far away, behind the word mountains" },
  { speciality: "Cardiology", description: "Far far away, behind the word mountains" },
  { speciality: "Traumatology", description: "Far far away, behind the word mountains" },
  { speciality: "Nuclear Magnetic", description: "Far far away, behind the word mountains" },
  { speciality: "X-ray", description: "Far far away, behind the word mountains" },
];

const DepartmentItem = ({ speciality, description }) => (
  <div className="department-wrap p-4 ftco-animate">
    <div className="text p-2 text-center">
      <div className="icon">
        <span className="flaticon-stethoscope"></span>
      </div>
      <h3><NavLink to={`/speciality/${speciality}`}>{speciality}</NavLink></h3>
      <p>{description}</p>
    </div>
  </div>
);

function Department() {
  return (
    <section className="ftco-section ftco-no-pt ftco-no-pb" id="department-section">
      <div className="container-fluid px-0">
        <div className="row no-gutters">
          <div className="col-md-4 d-flex">
            <div className="img img-dept align-self-stretch" style={{backgroundImage: "url('assets/images/dept-1.jpg')"}}></div>
          </div>

          <div className="col-md-8">
            <div className="row no-gutters">
              <div className="col-md-4">
                {departments.slice(0, 3).map((department, index) => (
                  <DepartmentItem key={index} {...department} />
                ))}
              </div>

              <div className="col-md-4">
                {departments.slice(3, 6).map((department, index) => (
                  <DepartmentItem key={index} {...department} />
                ))}
              </div>

              <div className="col-md-4">
                {departments.slice(6).map((department, index) => (
                  <DepartmentItem key={index} {...department} />
                ))}
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}

export default Department;
