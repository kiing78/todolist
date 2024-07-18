import logo from './logo.svg';
import './App.css';
import Button from './component/Button';
import CreateItemForm from './component/CreateItemForm';
import ListItem from './component/ListItem';


function App() {
  return (
    <div>
    <CreateItemForm /> 
    <ListItem />
    </div>
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>
  );
}

export default App;
