/* 
Dynamic Component - Class Component

What will happen when you call [new Vote()]
1. rule verification first and then properties initialization 
  constructor(props) {
    super(props); // link propos to VoteDynamic instance
    console.log(this.props);
  }

  Even you didnt link props to VoteDynamic instance, React will also
  link the props to the instance.

  2. Initialize state
  Need to initialize manually, if we didnt do any related operation, it 
  set set a state by default, the default value is null
  this.state = null;

  ------
  vue you can update state to update view, but React you can't.
  this.state.xxx = xxx. This operation only update the status, but
  can't let the view update.

  We can use this way to update the state.
  this.setState((prevState) => ({
    supNum: prevState.supNum + 1
  }))
  
  setState() -> update state & view
  forceUpdate() -> no matter you update or not it will update view 

  3. Trigger componentWillMount Hook Function
  componentWillMount() -> you will see alert in the console.
  UNSAFE_componentWillMount() -> you will see red alerts in the console.
  (If you use <React.strictMode>)

  4. Triger render()
  5. Triger componentDidMount()
 */

import React from "react";
import PropTypes from "prop-types";

class VoteDynamic extends React.Component {
  static defaultProps = {
    num: 0,
  };

  static propTypes = {
    title: PropTypes.string.isRequired,
    num: PropTypes.number,
  };

  constructor(props) {
    super(props);
    console.log(this);
  }

  // Initialize state
  state = {
    supNum: 10,
    oppNum: 5,
  };

  render() {
    let { title } = this.props,
      { supNum, oppNum } = this.state;
    return (
      <div className="vote-box">
        <div className="header">
          <h2 className="title">{title}</h2>
          <span>Totle Vote Number: {supNum + oppNum}</span>
        </div>

        <div className="main">
          <p>Support Number : {supNum}</p>
          <p>Opposite Number: {oppNum}</p>
        </div>

        <div className="footer">
          <button
            onClick={() => {
              this.setState((prevState) => ({
                supNum: prevState.supNum + 1,
              }));
              console.log("Current sppNum: ", this.state.supNum);
            }}
            value="support"
          >
            Support
          </button>
          <button
            onClick={() => {
              this.state.oppNum++;
              this.forceUpdate();
              console.log("Current oppNum: ", this.state.oppNum);
            }}
          >
            Opposite
          </button>
        </div>
      </div>
    );
  }

  UNSAFE_componentWillMount() {
    console.log(
      "componentWillMount() -> This will run before the 1st render() !!! "
    );
    console.log("you will see the yellow alert");
  }

  componentDidMount() {
    console.log("componentDidMount() -> This will run after the 1st render");
  }
}
export default VoteDynamic;
