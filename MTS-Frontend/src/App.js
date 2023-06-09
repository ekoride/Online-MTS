
import './App.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'

import NavigationBar from './components/NavigationBar';
import Welcome from './components/Welcome';
import {Container, Row} from 'react-bootstrap';
import Footer from './components/Footer';
import Movies from './components/Movies';
import AddMovie from './components/addMovie';
import Login from './components/Login';
import Register from './components/Register';
function App() {
  return (
    <Router>
      <NavigationBar />
      <Container>
        <Row>
          <Routes>
            <Route path="/"  element={<Welcome />}></Route>
            <Route path="/movies" element={<Movies />}></Route>
            <Route path="/addMovie" element={<AddMovie />}></Route>
            <Route path="/login" element={<Login />}></Route>
            <Route path="/register" element={<Register />}></Route>
          </Routes>
        </Row>
      </Container>
      {/* <Footer /> */}
    </Router>
  );
}

export default App;
