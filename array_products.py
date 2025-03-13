import typing

def calculate_products(numbers: typing.List[int]) -> typing.List[int]:
    if not isinstance(numbers, list):
        raise ValueError("Input must be a list of integers")
    if not all(isinstance(num, int) for num in numbers):
        raise ValueError("Input must be a list of integers")
    if len(numbers) == 0:
        return []
    if len(numbers) == 1:
        return [0]
    products = [1] * len(numbers)
    left_product = 1
    for i in range(len(numbers)):
        products[i] *= left_product
        left_product *= numbers[i]
    right_product = 1
    for i in range(len(numbers) - 1, -1, -1):
        products[i] *= right_product
        right_product *= numbers[i]
    return products

# Example usage:
print(calculate_products([1, 2, 3, 4]))  # Output: [24, 12, 8, 6]
print(calculate_products([1, 0, 3, 4]))  # Output: [0, 12, 0, 0]