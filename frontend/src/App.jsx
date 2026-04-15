import { useState } from 'react'
import enemy from './assets/devil.jpg'
import water from './assets/water.png'
import fire from './assets/fire.png'
import green from './assets/green.png'


import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <section>
          <div className="battle-container">
            <img src={enemy} className="enemy"  />
            <img src={water} className="ally-1" />
            <img src={fire} className="ally-2" />
            <img src={green} className="ally-3" />
          </div>
        </section>
    </>
  )
}

export default App
