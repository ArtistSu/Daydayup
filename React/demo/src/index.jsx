import React from "react";
import ReactDOM from "react-dom/client";
import "./jsxHandle";
// Day02
import DemoOne from "./views/Day02";
// Day03
import Day03Props from "./views/Day03-props";
import Day03Slot from "./views/Day03-slot";
import Vote from "./views/Day03-staticComponent";
import ClassUseCase from "./views/Day04-classUseCase";
import VoteDynamic from "./views/Day04-dynamicComponent";
import Day05 from "./views/Day05-ref";
import Day06 from "./views/Day06-setState";
import Day07 from "./views/Day07-syntheticExvent";

const root = ReactDOM.createRoot(document.getElementById("root"));
let context = "Allen 1st Demo";
let flag = false;
let flag2 = true;

let data = [
  {
    id: 1,
    context: "Allen study",
  },
  {
    id: 2,
    context: "Allen study2",
  },
];

const cuc = new ClassUseCase(10, 20);
console.log(cuc);

root.render(
  <>
    <div>{context}</div>
    <button>hhh</button>
    <h2
      style={{
        color: "red",
        fontSize: "18px",
      }}
    >
      {" "}
      I love study
    </h2>
    <div className="NotClass"> </div>
    {/* Base flag to control button display or hide */}
    <button
      style={{
        display: flag ? "block" : "none",
      }}
    >
      button1
    </button>
    {flag2 ? <button>button2</button> : null}
    <br />
    <button>{flag2 ? "True show this" : "False show this"}</button>
    {/* Get an array from server, dynamic binding loop */}
    <h2>News</h2>
    <ul className="news-box">
      {data.map((item, index) => {
        return (
          <li key={item.id}>
            <em>{index + 1}</em>
            &nbsp;&nbsp;
            <span>{item.context}</span>
          </li>
        );
      })}
    </ul>
    <br />
    {/* No array, I want to create 5 button with loop */}
    {new Array(5).fill(null).map((_, index) => {
      return <button key={index}>button{index + 1}</button>;
    })}
    {/* Day02 */}
    <h2>Day 02</h2>
    <DemoOne title="I am title" x={10} data={[10, 20]}>
      <span>children 1</span>
      <span>children 2</span>
    </DemoOne>
    {/* Day03 */}
    <h2>Day 03</h2>
    <Day03Props title="sth about object - props"></Day03Props>
    <Day03Slot>
      <div slot="footer">children-end</div>
      <div slot="header">children-start</div>
    </Day03Slot>
    <br />
    <Day03Slot>
      <div>children-start</div>
    </Day03Slot>
    <br />
    <Day03Slot></Day03Slot>
    <Vote title="I wanna test static component!!!" />

    {/* Day04 */}
    <h2> Day04 </h2>
    <h3> F12 filter "ClassUseCase" to check the result </h3>

    <VoteDynamic title="This is Dynamic Component" />

    {/* Day05 */}
    <Day05></Day05>

    {/* Day06 */}
    <Day06></Day06>

    {/* Day07 */}
    <Day07></Day07>
  </>
);
