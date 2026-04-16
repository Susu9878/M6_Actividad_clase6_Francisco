import { useState, useEffect } from "react";
import { initializeApp } from "firebase/app";
import { getFirestore, doc, onSnapshot } from "firebase/firestore";

import enemy from "./assets/devil.jpg";
import water from "./assets/water.png";
import fire from "./assets/fire.png";
import green from "./assets/green.png";

import "./App.css";

const firebaseConfig = {
  apiKey: "AIzaSyARNgekkxJ0kr1vzRyGE2EN1Z2AEPee7R8",
  authDomain: "m6fransisco.firebaseapp.com",
  projectId: "m6fransisco",
  storageBucket: "m6fransisco.firebasestorage.app",
  messagingSenderId: "241553688972",
  appId: "1:241553688972:web:3eb1aaf0f3ec3e076aeea9",
};

const app = initializeApp(firebaseConfig);
const db = getFirestore(app);

function App() {
  const [playerHealth, setPlayerHealth] = useState(100);

  const [enemyHealth, setEnemyHealth] = useState(0);
  const [loading, setLoading] = useState(false);

  const battleId = "battle1";

  const attackBoss = async (type) => {
    if (loading) return;
    setLoading(true);

    try {
      await fetch(`http://localhost:8080/battle/attack/${battleId}/${type}`, {
        method: "POST",
      });
    } catch (err) {
      console.error("Error attacking boss:", err);
    }

    setLoading(false);
  };

  useEffect(() => {
    let unsub;

    const initBattle = async () => {
      await fetch(`http://localhost:8080/battle/reset/${battleId}`, {
        method: "POST",
      });

      unsub = onSnapshot(doc(db, "battle", battleId), (docSnap) => {
        if (docSnap.exists()) {
          const data = docSnap.data();
          setEnemyHealth(data.boss.hp);
        }
      });
    };

    initBattle();

    return () => {
      if (unsub) unsub();
    };
  }, []);
  
  return (
    <>
      <section>
        <h1 className="title">DESTROY EVIL JAVA</h1>
        <div className="enemy-container">
          <img src={enemy} className="enemy" />
          <h3>Health bar: {enemyHealth} </h3>
        </div>

        <div className="battle-container">
          <img src={green} className="ally" />
          <button className="counter-green" onClick={() => attackBoss("green")}>
            Green attack!!!
          </button>

          <img src={water} className="ally" />
          <button className="counter-blue" onClick={() => attackBoss("water")}>
            Water attack!!!
          </button>

          <img src={fire} className="ally" />
          <button className="counter-red" onClick={() => attackBoss("red")}>
            Fire attack!!!
          </button>

          <h4 className="health-text">Health:{playerHealth}</h4>
        </div>
      </section>
    </>
  );
}

export default App;
