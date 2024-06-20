import React, { useEffect, useState } from "react";
import EmployeeService from "../Service/EmployeeService";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEdit, faTrash } from "@fortawesome/free-solid-svg-icons";

const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = () => {
    EmployeeService.getAllEmployees()
      .then((response) => {
        setEmployees(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const deleteEmployee=(employeeId)=>{
    EmployeeService.deleteEmployee(employeeId).then((response)=>{
      fetchEmployees();
      console.log(response);

    }).catch((error)=>{
      console.log(error);
    })
  }

  return (
    <div className="container">
      <h2 className="text-center">List Employees</h2>
      <Link to="/add-employee" className="btn btn-primary mb-2">
        Add Employee
      </Link>
      <table className="table table-bordered table-striped">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email Id</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td> {employee.id} </td>
              <td> {employee.firstName} </td>
              <td>{employee.lastName}</td>
              <td>{employee.emailId}</td>
              <td>
                <Link style={{ marginRight: 4 }} to={`/edit-employee/${employee.id}`}>
                  <FontAwesomeIcon icon={faEdit} />
                </Link>
                <FontAwesomeIcon
                  style={{ color: "red", marginLeft: 4, cursor: "pointer" }}
                  icon={faTrash}
                  onClick={() => deleteEmployee(employee.id)}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
