import React, { useState } from "react";
import { Calendar, momentLocalizer } from "react-big-calendar";
import moment from "moment";
import "react-big-calendar/lib/css/react-big-calendar.css";
const localizer = momentLocalizer(moment);


function Appointment() {
  
  return (
    <>
      <div class="col-md-5 d-flex">
	        	<div class="appointment-wrap bg-white p-5 d-flex align-items-center">
		        	<form action="#" class="appointment-form ftco-animate">
		        		<h3>MAKE APPOINTMENT</h3>
		    				<div class="">
			    				<div class="form-group">
			    					<input type="text" class="form-control" placeholder="First Name"/>
			    				</div>
			    				<div class="form-group">
			    					<input type="text" class="form-control" placeholder="Last Name"/>
			    				</div>
		    				</div>
		    				<div class="">
		    					<div class="form-group">
			    					<div class="form-field">
	          					<div class="select-wrap">
	                      <div class="icon"><span class="ion-ios-arrow-down"></span></div>
	                      <select name="" id="" class="form-control">
	                      	<option value="">Select Your Services</option>
	                        <option value="">Neurology</option>
	                        <option value="">Cardiology</option>
	                        <option value="">Dental</option>
	                        <option value="">Ophthalmology</option>
	                        <option value="">Other Services</option>
	                      </select>
	                    </div>
			              </div>
			    				</div>
		    					<div class="form-group">
			    					<input type="text" class="form-control" placeholder="Phone"/>
			    				</div>
		    				</div>
		    				<div class="">
			    				<div class="form-group">
			    					<div class="input-wrap">
			            		<div class="icon"><span class="ion-md-calendar"></span></div>
			            		<input type="text" class="form-control appointment_date" placeholder="Date"/>
		            		</div>
			    				</div>
			    				<div class="form-group">
			    					<div class="input-wrap">
			            		<div class="icon"><span class="ion-ios-clock"></span></div>
			            		<input type="text" class="form-control appointment_time" placeholder="Time"/>
		            		</div>
			    				</div>
		    				</div>
		    				<div class="">
		    					<div class="form-group">
			              <textarea name="" id="" cols="30" rows="2" class="form-control" placeholder="Message"></textarea>
			            </div>
			            <div class="form-group">
			              <input type="submit" value="Appointment" class="btn btn-secondary py-3 px-4"/>
			            </div>
		    				</div>
		    			</form>
		    		</div>
	    </div>
    </>
  );
}

export default Appointment;
