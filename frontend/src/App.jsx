import { useState } from "react";
import enemy from "./assets/devil.jpg";
import water from "./assets/water.png";
import fire from "./assets/fire.png";
import green from "./assets/green.png";

import "./App.css";

function App() {
  const [blueDmg, setblueDmg] = useState(10);
  const [redDmg, setredDmg] = useState(10);
  const [greenDmg, setgreenDmg] = useState(10);
  const [blueHealth, setblueHealth] = useState(100);
  const [redHealth, setredHealth] = useState(100);
  const [greenHealth, setgreenHealth] = useState(100);
  const [enemyHealth, setEnemyHealth] = useState(600);

  return (
    <>
      <section>
        <h1 className="title">DESTROY EVIL JAVA</h1>
        <div className="enemy-container">
          <img src={enemy} className="enemy" />
          <h3>Health bar: {enemyHealth} </h3>
        </div>

        <div className="battle-container">
          <img src={water} className="ally" />
          <button
            className="counter-blue"
            onClick={() => setEnemyHealth((enemyHealth) => enemyHealth - blueDmg)}
          >
            Water attack!!!
          </button>
          <h4 className="health-text">Health:{blueHealth}</h4>

          <img src={fire} className="ally" />
          <button
            className="counter-red"
            onClick={() => setEnemyHealth((enemyHealth) => enemyHealth - redDmg)}
          >
            Fire attack!!!
          </button>
          <h4 className="health-text">Health:{redHealth}</h4>

          <img src={green} className="ally" />
          <button
            className="counter-green"
            onClick={() => setEnemyHealth((enemyHealth) => enemyHealth - greenDmg)}
          >
            Green attack!!!
          </button>
          <h4 className="health-text">Health:{greenHealth}</h4>
        </div>
      </section>
    </>
  );
}

export default App;
