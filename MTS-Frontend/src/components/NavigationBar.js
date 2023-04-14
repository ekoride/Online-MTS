import React from 'react'
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav';
import Container from 'react-bootstrap/Container';
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faMoneyBillTransfer,
  faSignInAlt,
  faUserPlus,
} from "@fortawesome/free-solid-svg-icons";
import { useSelector, useDispatch } from 'react-redux';
import { userSelector, setLoggedOut } from '../features/user/userSlice';

export default function NavigationBar() {

  const dispatch = useDispatch();
  const { isLoggedIn, user_name } = useSelector(userSelector);

  const guestLinks = (
    <>
      <Nav className="navbar-right">
        <Link to={"register"} className="navbar-brand"><FontAwesomeIcon icon={faUserPlus} /> Register</Link>
        <Link to={"login"} className="navbar-brand"><FontAwesomeIcon icon={faSignInAlt} /> Login</Link>
      </Nav>
    </>
  )

  const userLinks = (
    <>
      <Nav className="me-auto">
          <Link to={"movies"} className="navbar-brand">Movies</Link>
          <Link to={"addMovie"} className="navbar-brand">Add Movie</Link>
          {/* <Nav.Link href="#pricing">Pricing</Nav.Link> */}
      </Nav>
      <Nav className="navbar-right">
         <Link className="navbar-brand">Welcome {user_name}</Link>
        <Link to="/" className="navbar-brand" onClick={() => dispatch(setLoggedOut())}><FontAwesomeIcon icon={faSignInAlt} /> Logout</Link>
      </Nav>
    </>
  )

  return (
    <>
        <Navbar bg="light" variant="light">
            <Container>
            <Link to={""} className="navbar-brand"><FontAwesomeIcon icon={faMoneyBillTransfer} /> MTS</Link>
                {isLoggedIn? userLinks : guestLinks}

            </Container>    
        </Navbar>  

    </>
  )
}
