class ClassUseCase {
  // constructor -> No parameters can be omitted
  constructor(x, y) {
    this.total = x + y; // total -> private property
  }

  num = 200; // eaqual to this.num = 200, num -> private property

  getNum = () => {
    // Arrow functions do not have their own this keyword, this uses the host's
    console.log(this);
  };

  // sum() -> set a public method on ClassUseCase.prototype
  sum() {}

  // Set private static property / method
  static avg = 100;
  static average() {}
}

// Set public property on prototype
ClassUseCase.prototype.y = 2000;
export default ClassUseCase;
