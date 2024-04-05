def solution(balls, share)
    factorial(balls) / (factorial(balls - share) * factorial(share))
  end

  def factorial(n)
    (1..n).inject(1) { |result, i| result * i }
  end